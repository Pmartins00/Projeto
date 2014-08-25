package br.com.coautores.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="imageViewBean")
public class ImageViewBean {
	
	 private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 9; i++) {
            images.add("img" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
    	System.out.println("imagens:"+images.size());
        return images;
    }

}
