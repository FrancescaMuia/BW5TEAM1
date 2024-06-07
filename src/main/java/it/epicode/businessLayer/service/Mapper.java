package it.epicode.businessLayer.service;

public interface Mapper<D, S> {

    S map(D input);
}