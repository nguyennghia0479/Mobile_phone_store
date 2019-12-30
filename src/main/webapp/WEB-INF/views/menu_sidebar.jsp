<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-sm-3">
    <br>
    <ul class="list-group">
        <li class="list-group-item">
            <h5>Brand</h5>
            <form id="sortBrand" action="${pageContext.request.contextPath}/sort-brand" method="post">
            	<div class="row">
	            	<div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="apple" name="brand" value="apple" class="custom-control-input" onclick="sortBrand()" ${brand eq 'apple' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="apple">Apple</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="samsung" name="brand" value="samsung" class="custom-control-input" onclick="sortBrand()" ${brand eq 'samsung' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="samsung">Samsung</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="nokia" name="brand" value="nokia" class="custom-control-input" onclick="sortBrand()" ${brand eq 'nokia' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="nokia">Nokia</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="vsmart" name="brand" value="vsmart" class="custom-control-input" onclick="sortBrand()" ${brand eq 'vsmart' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="vsmart">Vsmart</label>
	                    </div>
	                </div>
	                 <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="huawei" name="brand" value="huawei" class="custom-control-input" onclick="sortBrand()" ${brand eq 'huawei' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="huawei">Huawei</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="xiaomi" name="brand" value="xiaomi" class="custom-control-input" onclick="sortBrand()" ${brand eq 'xiaomi' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="xiaomi">Xiaomi</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="oppo" name="brand" value="oppo" class="custom-control-input" onclick="sortBrand()" ${brand eq 'oppo' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="oppo">Oppo</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="honor" name="brand" value="honor" class="custom-control-input" onclick="sortBrand()" ${brand eq 'honor' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="honor">Honor</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="realme" name="brand" value="realme" class="custom-control-input" onclick="sortBrand()" ${brand eq 'realme' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="realme">Realme</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-6">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="vivo" name="brand" value="vivo" class="custom-control-input" onclick="sortBrand()" ${brand eq 'vivo' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="vivo">Vivo</label>
	                    </div>
	                </div>
            	</div>
            </form>
        </li>
        <li class="list-group-item">
            <h5>Price</h5>
            <form id="sortPrice" action="${pageContext.request.contextPath}/sort-price" method="post">
            	<div class="row">
	            	<div class="col-sm-12 col-md-12">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="u3" name="priceType" value="u3" class="custom-control-input" onclick="sortPrice()" ${priceType eq 'u3' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="u3">
	                        	Under <fmt:formatNumber value="3000000" maxFractionDigits="3"/> (VND)
	                        </label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-12">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="f3t5" name="priceType" value="f3t5" class="custom-control-input" onclick="sortPrice()" ${priceType eq 'f3t5' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="f3t5">
								<fmt:formatNumber value="3000000" maxFractionDigits="3"/> - <fmt:formatNumber value="5000000" maxFractionDigits="3"/> (VND)
							</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-12">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="f5t10" name="priceType" value="f5t10" class="custom-control-input" onclick="sortPrice()" ${priceType eq 'f5t10' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="f5t10">
								<fmt:formatNumber value="5000000" maxFractionDigits="3"/> - <fmt:formatNumber value="10000000" maxFractionDigits="3"/> (VND)
							</label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-12">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="f10t15" name="priceType" value="f10t15" class="custom-control-input" onclick="sortPrice()" ${priceType eq 'f10t15' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="f10t15">
	                        	<fmt:formatNumber value="10000000" maxFractionDigits="3"/> - <fmt:formatNumber value="15000000" maxFractionDigits="3"/> (VND)
	                        </label>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-12">
	                    <div class="custom-control custom-radio">
	                        <input type="radio" id="a15" name="priceType" value="a15" class="custom-control-input" onclick="sortPrice()" ${priceType eq 'a15' ? 'checked' : ''}>
	                        <label class="custom-control-label" for="a15">
	                        	Above <fmt:formatNumber value="15000000" maxFractionDigits="3"/> (VND)
	                        </label>
	                    </div>
	                </div>
            	</div>
            </form>
        </li>
    </ul>
</div>