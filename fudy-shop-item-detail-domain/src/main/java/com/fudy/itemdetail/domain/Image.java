package com.fudy.itemdetail.domain;

import lombok.Data;

@Data
public class Image {
    private String url;

    public Image() {
    }

    public Image(String url) {
        this.url = url;
    }
}
