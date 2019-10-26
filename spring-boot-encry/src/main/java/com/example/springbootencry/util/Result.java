package com.example.springbootencry.util;

import java.util.HashMap;
import java.util.Map;

public class Result implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private boolean success = true;
    private Map data;

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public static Result createResult() {
        return new Result();
    }

    public Map getData() {
        return data;
    }

    public void setData(Map data) {
        this.data = data;
    }

    public void setDataValue(String key, Object value) {
        if (data == null) {
            data = new HashMap();
        }
        data.put(key, value);
    }


}
