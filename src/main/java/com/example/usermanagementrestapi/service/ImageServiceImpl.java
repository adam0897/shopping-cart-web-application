package com.example.usermanagementrestapi.service;

import com.example.usermanagementrestapi.entity.Images;
import com.example.usermanagementrestapi.exception.InternalServerException;
import com.example.usermanagementrestapi.exception.NotFoundException;
import com.example.usermanagementrestapi.model.dto.ImageDto;
import com.example.usermanagementrestapi.model.mapper.ImageMapper;
import com.example.usermanagementrestapi.repository.ImageRepository;
import com.example.usermanagementrestapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ImageDto> getListImages() {

        List<Images> imagesList = imageRepository.findAll();
        List<ImageDto> imageDtoS = new ArrayList<>();
        for (Images images: imagesList) {
            imageDtoS.add(ImageMapper.toImageDto(images));
        }

        return imageDtoS;
    }

    @Override
    public ImageDto getImagetById(int imageId) {

        Optional<Images> images = imageRepository.findById(imageId);
        if (!images.isPresent()){
            throw new NotFoundException("No images found");
        }

        return ImageMapper.toImageDto(images.get());
    }

    @Override
    public ImageDto createImage(ImageDto imageDto) {

        Images images = ImageMapper.toImages(imageDto);
        images.setProduct(productRepository.getOne(imageDto.getProductId()));
        imageRepository.save(images);

        return ImageMapper.toImageDto(images);
    }

    @Override
    public ImageDto updateImage(ImageDto imageDto, int imageId) {

        Optional<Images> images = imageRepository.findById(imageId);
        if (!images.isPresent()) {
            throw new NotFoundException("No images found");
        }

        Images updateImages = ImageMapper.toImages(imageDto, imageId);
        updateImages.setProduct(productRepository.getOne(imageDto.getProductId()));
        try {
            imageRepository.save(updateImages);
        } catch (Exception e) {
            throw new InternalServerException("Database error. Can't update images");
        }

        return ImageMapper.toImageDto(updateImages);
    }

    @Override
    public void deleteImage(int imageId) {

        Optional<Images> images = imageRepository.findById(imageId);
        if (!images.isPresent()) {
            throw new NotFoundException("No images found");
        }
        try {
            imageRepository.deleteById(imageId);
        } catch (Exception ex) {
            throw new InternalServerException("Database error. Can't delete images");
        }
    }
}
