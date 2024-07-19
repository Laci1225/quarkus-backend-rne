package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class PhotoCreateDto {
    @FormParam("name")
    @PartType("text/plain")
    public String name;

    @FormParam("data")
    @PartType("text/plain")
    public String data;

    @FormParam("mimeType")
    @PartType("text/plain")
    public String mimeType;
}
