package com.example.restaurant1.ui.gallery;

import java.util.List;

public class DelpapaResponse {
    public String code;
    public String message;
    public List<Delpapa> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Delpapa> getData() {
        return data;
    }

    public void setData(List<Delpapa> data) {
        this.data = data;
    }
}
