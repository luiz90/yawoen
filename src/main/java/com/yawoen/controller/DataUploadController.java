package com.yawoen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yawoen.service.DataUploadServiceImp;

@RestController
@RequestMapping("v1/data")
public class DataUploadController {
	
	@Autowired
	private DataUploadServiceImp dataUploadServiceImp;

}
