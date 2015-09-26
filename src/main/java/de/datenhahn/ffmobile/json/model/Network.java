package de.datenhahn.ffmobile.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.List;


public class Network {
    List<String> addresses;
    String mac;
    @JsonProperty("mesh")
    LinkedHashMap<String,MeshInterface> mesh;
    @JsonProperty("mesh_interfaces")
    List<String> meshInterfaces;

    public LinkedHashMap<String,MeshInterface> getMesh() {
        return mesh;
    }

    public void setMesh(LinkedHashMap<String,MeshInterface> mesh) {
        this.mesh = mesh;
    }

    public List<String> getMeshInterfaces() {
        return meshInterfaces;
    }

    public void setMeshInterfaces(List<String> meshInterfaces) {
        this.meshInterfaces = meshInterfaces;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

}