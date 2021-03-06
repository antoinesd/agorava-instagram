package org.agorava.instagram.jackson;

import org.agorava.instagram.model.InstagramProfile;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.List;

/**
 * User: Dje
 * Date: 20/04/13
 * Time: 17:36
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstagramProfileListHolder {

    private final List<InstagramProfile> list;

    @JsonCreator
    public InstagramProfileListHolder(@JsonProperty("data") @JsonDeserialize(using = InstagramProfileListDeserializer.class) List<InstagramProfile> list) {
        this.list = list;
    }

    public List<InstagramProfile> getList() {
        return list;
    }
}
