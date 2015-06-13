
package com.io.znk.ctalin.model.foursquare;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "checkinsCount",
    "usersCount",
    "tipCount"
})
public class Stats {

    @JsonProperty("checkinsCount")
    private Long checkinsCount;
    @JsonProperty("usersCount")
    private Long usersCount;
    @JsonProperty("tipCount")
    private Long tipCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The checkinsCount
     */
    @JsonProperty("checkinsCount")
    public Long getCheckinsCount() {
        return checkinsCount;
    }

    /**
     * 
     * @param checkinsCount
     *     The checkinsCount
     */
    @JsonProperty("checkinsCount")
    public void setCheckinsCount(Long checkinsCount) {
        this.checkinsCount = checkinsCount;
    }

    /**
     * 
     * @return
     *     The usersCount
     */
    @JsonProperty("usersCount")
    public Long getUsersCount() {
        return usersCount;
    }

    /**
     * 
     * @param usersCount
     *     The usersCount
     */
    @JsonProperty("usersCount")
    public void setUsersCount(Long usersCount) {
        this.usersCount = usersCount;
    }

    /**
     * 
     * @return
     *     The tipCount
     */
    @JsonProperty("tipCount")
    public Long getTipCount() {
        return tipCount;
    }

    /**
     * 
     * @param tipCount
     *     The tipCount
     */
    @JsonProperty("tipCount")
    public void setTipCount(Long tipCount) {
        this.tipCount = tipCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
