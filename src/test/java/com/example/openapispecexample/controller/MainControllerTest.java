package com.example.openapispecexample.controller;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.epages.restdocs.apispec.Schema;
import com.example.openapispecexample.dto.MainRequest;
import com.example.openapispecexample.dto.MainRequest.Patch;
import com.example.openapispecexample.dto.MainRequest.Post;
import com.example.openapispecexample.dto.MainRequest.Put;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(MainController.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Get ?????????")
    void getTest() throws Exception {
        mockMvc.perform(
                RestDocumentationRequestBuilders.get("/user")
            )
            .andExpect(status().isOk())
            .andDo(MockMvcRestDocumentationWrapper.document("test-get",
                ResourceSnippetParameters.builder()
                    .tag("?????????")
                    .summary("Get ?????????")
                    .description("Get ?????????")
                    .responseSchema(Schema.schema("MainResponse.Get"))
                    ,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                responseFields(
                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????????")
                )
            ));

    }

    @Test
    @DisplayName("Post ?????????")
    void postTest() throws Exception {
        MainRequest.Post request = new Post("post request");
        mockMvc.perform(
                RestDocumentationRequestBuilders.post("/user")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(request))
            )
            .andExpect(status().isCreated())
            .andDo(MockMvcRestDocumentationWrapper.document("test-post",
                ResourceSnippetParameters.builder()
                    .tag("?????????")
                    .summary("Post ?????????")
                    .description("Post ?????????")
                    .requestSchema(Schema.schema("MainRequest.Post"))
                    .responseSchema(Schema.schema("MainResponse.Post"))
                ,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                requestFields(
                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????")
                ),
                responseFields(
                    fieldWithPath("id").type(JsonFieldType.NUMBER).description("?????? ID")
                )));
    }

    @Test
    @DisplayName("Put ?????????")
    void putTest() throws Exception {
        Long requestId = 1L;
        MainRequest.Put requestBody = new Put("put request");

        mockMvc.perform(
                RestDocumentationRequestBuilders.put("/user/{id}", requestId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(requestBody))
            )
            .andExpect(status().isOk())
            .andDo(MockMvcRestDocumentationWrapper.document("test-put",
                ResourceSnippetParameters.builder()
                    .tag("?????????")
                    .summary("Put ?????????")
                    .description("Put ?????????")
                    .requestSchema(Schema.schema("MainRequest.Put"))
                    .responseSchema(Schema.schema("MainResponse.Put"))
                ,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                pathParameters(
                    parameterWithName("id").description("?????? ID")
                ),
                requestFields(
                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????")
                ),
                responseFields(
                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????")
                )
            ));
    }

    @Test
    @DisplayName("Patch ?????????")
    void patchTest() throws Exception {
        Long requestId = 1L;
        MainRequest.Patch requestBody = new Patch("patch request");

        mockMvc.perform(
                RestDocumentationRequestBuilders.patch("/user/{id}", requestId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(mapper.writeValueAsString(requestBody))
            )
            .andExpect(status().isOk())
            .andDo(MockMvcRestDocumentationWrapper.document("test-patch",
                ResourceSnippetParameters.builder()
                    .tag("?????????")
                    .summary("Patch ?????????")
                    .description("Patch ?????????")
                    .requestSchema(Schema.schema("MainRequest.Patch"))
                    .responseSchema(Schema.schema("MainResponse.Post"))
                ,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                pathParameters(
                    parameterWithName("id").description("?????? ID")
                ),
                requestFields(
                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????")
                ),
                responseFields(
                    fieldWithPath("message").type(JsonFieldType.STRING).description("?????? ?????????")
                )
            ));
    }

    @Test
    @DisplayName("Delete ?????????")
    void deleteTest() throws Exception {
        Long request = 1L;

        mockMvc.perform(
                RestDocumentationRequestBuilders.delete("/user/{id}", request)
            )
            .andExpect(status().isNoContent())
            .andDo(MockMvcRestDocumentationWrapper.document("test-delete",
                ResourceSnippetParameters.builder()
                    .tag("?????????")
                    .summary("Delete ?????????")
                    .description("Delete ?????????")
                ,
                preprocessRequest(prettyPrint()),
                preprocessResponse(prettyPrint()),
                pathParameters(
                    parameterWithName("id").description("?????? ID")
                )
            ));
    }
}