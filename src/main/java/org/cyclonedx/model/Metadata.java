/*
 * This file is part of CycloneDX Core (Java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) Steve Springett. All Rights Reserved.
 */
package org.cyclonedx.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.cyclonedx.util.CustomDateSerializer;

@JsonPropertyOrder({"timestamp", "tools", "authors"})
public class Metadata extends ExtensibleElement {

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date timestamp = new Date();
    private List<Tool> tools;
    private List<OrganizationalContact> authors;
    private Component component;
    private OrganizationalEntity manufacture;
    private OrganizationalEntity supplier;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @JacksonXmlElementWrapper(localName = "tools")
    @JacksonXmlProperty(localName = "tool")
    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public void addTool(Tool tool) {
        if (this.tools == null) {
            this.tools = new ArrayList<>();
        }
        this.tools.add(tool);
    }

    @JacksonXmlElementWrapper(localName = "authors")
    @JacksonXmlProperty(localName = "author")
    public List<OrganizationalContact> getAuthors() {
        return authors;
    }

    public void setAuthors(List<OrganizationalContact> authors) {
        this.authors = authors;
    }

    public void addAuthor(OrganizationalContact author) {
        if (this.authors == null) {
            this.authors = new ArrayList<>();
        }
        this.authors.add(author);
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public OrganizationalEntity getManufacture() {
        return manufacture;
    }

    public void setManufacture(OrganizationalEntity manufacture) {
        this.manufacture = manufacture;
    }

    public OrganizationalEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(OrganizationalEntity supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Metadata metadata = (Metadata) o;
        return Objects.equals(timestamp, metadata.timestamp) &&
                Objects.equals(tools, metadata.tools) &&
                Objects.equals(authors, metadata.authors) &&
                Objects.equals(component, metadata.component) &&
                Objects.equals(manufacture, metadata.manufacture) &&
                Objects.equals(supplier, metadata.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, tools, authors, component, manufacture, supplier);
    }
}
