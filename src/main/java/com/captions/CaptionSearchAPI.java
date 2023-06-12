package com.captions;

import java.util.*;

public class CaptionSearchAPI {

    private DataManager dataManager;

    public CaptionSearchAPI() {
        this.dataManager = DataManager.getInstance();
    }

    public List<String> search(String input) {
        String[] keywords = input.toLowerCase().split("[(\\s)|(,)|(;)|(\\.)]");
        Set<String> captions = new HashSet();
        for (String keyword : keywords) {
            captions.addAll(searchForKeyword(keyword));
        }
        if (captions.isEmpty()) {
            captions.add(Constants.NO_CAPTIONS);
        }
        List<String> captionList = new ArrayList<>(captions);
        Collections.shuffle(captionList);
        int numResults = Math.min(Constants.MAX_RESULTS, captionList.size());
        return captionList.subList(0, numResults);
    }

    Set<String> searchForKeyword(String keyword) {
        return dataManager.get(keyword);
    }
}
