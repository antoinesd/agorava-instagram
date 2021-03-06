package org.agorava.instagram.impl;

import org.agorava.InstagramBaseService;
import org.agorava.core.utils.URLUtils;
import org.agorava.instagram.InstagramUserService;
import org.agorava.instagram.jackson.InstagramProfileHolder;
import org.agorava.instagram.jackson.InstagramProfileListHolder;
import org.agorava.instagram.model.InstagramProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 00:27
 */
public class InstagramUserServiceImpl extends InstagramBaseService implements InstagramUserService {

    static final String GET_OWN_PROFILE_URL = "users/self";
    static final String GET_USER_PROFILE_URL = "users/";
    static final String SEARCH_USER_URL = "users/search";

    @Override
    public InstagramProfile getUserProfile() {
        return getService().get(buildUri(GET_OWN_PROFILE_URL), InstagramProfileHolder.class).getProfile();
    }


    @Override
    public InstagramProfile getUserProfile(String userId) {
        return getService().get(buildUri(GET_USER_PROFILE_URL + userId), InstagramProfileHolder.class).getProfile();
    }

    @Override
    public List<InstagramProfile> search(String query) {
        Map<String,String> parameters = new HashMap<String, String>();
        parameters.put("q", query);
        return getService().get(buildUri(SEARCH_USER_URL, parameters), InstagramProfileListHolder.class).getList();
    }


    @Override
    public List<InstagramProfile> search(String query, int count) {
        Map<String,String> parameters = new HashMap<String, String>();
        parameters.put("q", query);
        parameters.put("count", Integer.toString(count));
        return getService().get(buildUri(SEARCH_USER_URL, parameters), InstagramProfileListHolder.class).getList();
    }

}
