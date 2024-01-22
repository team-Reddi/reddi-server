package com.example.reddiserver.controller;

import com.example.reddiserver.common.ApiResponse;
import com.example.reddiserver.dto.brand.response.BrandContentsResponseDto;
import com.example.reddiserver.dto.brand.response.BrandResponseDto;
import com.example.reddiserver.repository.BrandRepository;
import com.example.reddiserver.service.BrandService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brand")
public class BrandController {

	private final BrandService brandService;

	@Operation(summary = "브랜드 리스트 조회")
	@GetMapping("/")
	public ApiResponse<Page<BrandResponseDto>> getBrandList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Page<BrandResponseDto> brandList = brandService.getBrandList(PageRequest.of(page, size));
		return ApiResponse.successResponse(brandList);
	}

	@Operation(summary = "브랜드 단건(상세) 조회")
	@GetMapping("/{id}")
	public ApiResponse<BrandContentsResponseDto> getBrandById(Long id) {
		BrandContentsResponseDto brand = brandService.getBrandById(id);
		return ApiResponse.successResponse(brand);
	}






}