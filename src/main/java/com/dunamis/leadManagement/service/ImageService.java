package com.dunamis.leadManagement.service;
import com.dunamis.leadManagement.domain.Image;
import java.util.List;

public interface ImageService {
    public Image findById(Integer id);
    public Image saveImage(Image image_1,Integer uploadFlag);
    public List<Image> findAll();
   
   
}