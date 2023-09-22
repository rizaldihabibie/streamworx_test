package com.example.MainService.response;

import lombok.*;
import org.simpleframework.xml.ElementList;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostXMLResponse {

    @ElementList(inline = true, entry = "row")
    private List<PostResponse> postResponseList;
}
