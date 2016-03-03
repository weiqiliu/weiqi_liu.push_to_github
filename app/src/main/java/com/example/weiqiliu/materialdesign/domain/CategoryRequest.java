package com.example.weiqiliu.materialdesign.domain;

import java.util.List;

public class CategoryRequest {
    private List<String> tags;

    public CategoryRequest(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
