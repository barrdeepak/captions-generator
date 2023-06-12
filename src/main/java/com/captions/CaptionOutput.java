package com.captions;

import java.util.List;

public class CaptionOutput {
    private int count;
    private List<String> captions;

    public CaptionOutput(int count, List<String> captions) {
        this.count = count;
        this.captions = captions;
    }

    public CaptionOutput() {
    }

    public int getCount() {
        return count;
    }

    public List<String> getCaptions() {
        return captions;
    }
}
