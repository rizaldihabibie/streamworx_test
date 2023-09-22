package com.example.posts.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JacksonXmlRootElement(localName = "root")
public class PostXMLResponse {

    @JacksonXmlProperty(localName = "row")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PostResponse> postResponseList;
}
