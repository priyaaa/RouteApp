package priyanka.assignment.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 15-02-2018.
 */

public class Routes implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 510179407815786433L;
    private List<Route> routes = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
