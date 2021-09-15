package com.jelipo.ishake.core.annotation;

public @interface HttpGet {

    /**
     * PATH+QUERY值 <p>
     * 包含
     * <p><p>
     * 如URL为"http://localhost:8080/china/shanghai/pudong?road=RoadShandong&code=200940"<p>
     * value可以为:
     * <blockquote><pre>
     *     /china/shanghai/pudong?road=RoadShandong&code=200940
     *     /pudong?road=${roadName}&code=200940
     * </pre></blockquote>
     */
    String value();


}
