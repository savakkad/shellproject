package com.shell.markethub.base.util.jsonhandlers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Map;

public class JsonMerger {

    public static enum ConflictStrategy {
        THROW_EXCEPTION, PREFER_FIRST_OBJ, PREFER_SECOND_OBJ, PREFER_NON_NULL;
    }

    public static class JsonObjectExtensionConflictException extends Exception {
		private static final long serialVersionUID = 1L;
		public JsonObjectExtensionConflictException(String message) {
            super(message);
        }
    }
    
    /**
     * This method is used to merge multiple jsons to a destiinationObject
     * @param destinationObject : The json object to which the other jsons has to be merged
     * @param conflictResolutionStrategy : The json object to which the precedence has to be given when same objects are found in source and target.
     * @param objs  : The collection of jsons which are to be merged to destinationObject
     * @return : The merged object
     * @throws JsonObjectExtensionConflictException
     */
    public static JsonObject mergeJsonObjects(JsonObject destinationObject, ConflictStrategy conflictResolutionStrategy, JsonObject ... objs) 
            throws JsonObjectExtensionConflictException {
        for (JsonObject obj : objs) {
            mergeJsonObject(destinationObject, obj, conflictResolutionStrategy);
        }
        return destinationObject;
    }

    /**
     * 
     * @param leftObj : The target object to which the right object will be merged
     * @param rightObj : The object which will be merged into left object
     * @param conflictStrategy : If the same object is found in both jsons, The object to be considered will be decided on the strategy passed
     * @return : The merged object
     * @throws JsonObjectExtensionConflictException
     */
    private static JsonObject mergeJsonObject(JsonObject leftObj, JsonObject rightObj, ConflictStrategy conflictStrategy) 
            throws JsonObjectExtensionConflictException {
        for (Map.Entry<String, JsonElement> rightEntry : rightObj.entrySet()) {
            String rightKey = rightEntry.getKey();
            JsonElement rightVal = rightEntry.getValue();
            if (leftObj.has(rightKey)) {
                //conflict                
                JsonElement leftVal = leftObj.get(rightKey);
                if (leftVal.isJsonArray() && rightVal.isJsonArray()) {
                    JsonArray leftArr = leftVal.getAsJsonArray();
                    JsonArray rightArr = rightVal.getAsJsonArray();
                    //concat the arrays -- there cannot be a conflict in an array, it's just a collection of stuff
                    for (int i = 0; i < rightArr.size(); i++) {
                        leftArr.add(rightArr.get(i));
                    }
                } else if (leftVal.isJsonObject() && rightVal.isJsonObject()) {
                    //recursive merging
                    mergeJsonObject(leftVal.getAsJsonObject(), rightVal.getAsJsonObject(), conflictStrategy);
                } else {//not both arrays or objects, normal merge with conflict resolution
                    handleMergeConflict(rightKey, leftObj, leftVal, rightVal, conflictStrategy);
                }
            } else {//no conflict, add to the object
                leftObj.add(rightKey, rightVal);
            }
        }
        return leftObj;
    }

    private static void handleMergeConflict(String key, JsonObject leftObj, JsonElement leftVal, JsonElement rightVal, ConflictStrategy conflictStrategy) 
            throws JsonObjectExtensionConflictException {
        {
            switch (conflictStrategy) {
                case PREFER_FIRST_OBJ:
                    break;//do nothing, the right val gets thrown out
                case PREFER_SECOND_OBJ:
                    leftObj.add(key, rightVal);//right side auto-wins, replace left val with its val
                    break;
                case PREFER_NON_NULL:
                    //check if right side is not null, and left side is null, in which case we use the right val
                    if (leftVal.isJsonNull() && !rightVal.isJsonNull()) {
                        leftObj.add(key, rightVal);
                    }//else do nothing since either the left value is non-null or the right value is null
                    break;
                case THROW_EXCEPTION:
                    throw new JsonObjectExtensionConflictException("Key " + key + " exists in both objects and the conflict resolution strategy is " + conflictStrategy);
                default:
                    throw new UnsupportedOperationException("The conflict strategy " + conflictStrategy + " is unknown and cannot be processed");
            }
        }
    }
}
