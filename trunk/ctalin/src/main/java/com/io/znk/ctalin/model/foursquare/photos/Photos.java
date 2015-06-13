
package com.io.znk.ctalin.model.foursquare.photos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "count",
    "items",
    "dupesRemoved"
})
public class Photos {

    @JsonProperty("count")
    private Long count;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
    @JsonProperty("dupesRemoved")
    private Long dupesRemoved;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The count
     */
    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The items
     */
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The dupesRemoved
     */
    @JsonProperty("dupesRemoved")
    public Long getDupesRemoved() {
        return dupesRemoved;
    }

    /**
     * 
     * @param dupesRemoved
     *     The dupesRemoved
     */
    @JsonProperty("dupesRemoved")
    public void setDupesRemoved(Long dupesRemoved) {
        this.dupesRemoved = dupesRemoved;
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
