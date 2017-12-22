<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.rj.bookshop.Service.BookService"%>
<%@page import="com.rj.bookshop.Entity.Book"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- Enable zoom
======================================	 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Install fonts
======================================	 -->
<link href='https://fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900' rel='stylesheet' type='text/css'>

<!-- Ico font
=======================================	 -->
<link rel="stylesheet" href="css/icofont.css">

<!-- Animate css
=======================================	 -->
<link rel="stylesheet" href="css/animate.min.css">

<!-- Venobox css
=========================================	 -->
<link rel="stylesheet" href="js/venobox/venobox.css">

<!-- Camera Slider
=======================================	 -->
<link rel="stylesheet" href="css/camera.css">

<!-- Ui min css
=======================================	 -->
<link rel="stylesheet" href="css/jquery-ui.min.css">

<!-- Owl Carousel Theme
=======================================	 -->
<link rel="stylesheet" href="css/owl.theme.default.min.css">

<!-- Owl carousel 
=======================================	 -->
<link rel="stylesheet" href="css/owl.carousel.min.css">

<!-- Slick carousel Theme
=======================================	 -->
<link rel="stylesheet" href="css/slick-theme.css">

<!-- Slick css
=======================================	 -->
<link rel="stylesheet" href="css/slick.css">

<!-- Mean Menu
=======================================	 -->
<link rel="stylesheet" href="css/meanmenu.min.css">

<!-- Uikit Min css
=======================================	 -->
<link rel="stylesheet" href="css/uikit.min.css">

<!-- Bootstrap css
=======================================	 -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Style css/Base css/Main css
=======================================	 -->
<link rel="stylesheet" href="style.css">

<!-- FAVICONS -->
<link rel="shortcut icon" href="img/icon/favicon.png" type="image/x-icon">
</head>
<body class="menz ">

<!-- ========================================
	==Start Preloader==
======================================== -->
<div class="preloader">
<div class="preloader-inner-area">
	<div class="loader-overlay">
		<div class="loader-container">
			<div class="block1"></div>
			<div class="block2"></div>
			<div class="block3"></div>
			<div class="block4"></div>
		</div>
	</div>
</div>
</div>
<!-- ========================================
	==Start Preloader==
======================================== -->

<!-- ========================================
		==Start Top Toolbar==
======================================== -->
<div class="top-toolbar">
</div>
<!-- ========================================
		==End Top Toolbar==
======================================== -->
<!-- ========================================
	==Start Navigation Bar==
======================================== -->
<div class="navigation-bar">
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="navigation-bar-inner-area clearfix">
				<div class="row">
					<div class="top-toolbar-inner-area">
						<div class="col-md-4 col-md-offset-2 col-sm-6">
							<div class="top-toolbar-left">
								<ul>
									<li>
										<a href="">
											<span><i class="icofont icofont-ui-call"></i></span>
											+0123456785
										</a>
									</li>
									<li>
										<a href="mailto:youremail@gmail.com">
											<span><i class="icofont icofont-envelope"></i></span>
											youremail@gmail.com
										</a>
									</li>
								</ul>
							</div>		
						</div>
						<div class="col-md-6 col-sm-6">
							<div class="top-toolbar-right">
								<ul>
									<li>
										<a href="#" data-uk-modal="{target:'#menu-searchbox'}">
											<i class="icofont icofont-search-alt-1"></i>
										</a>
									</li>
									<li>
										<a href="ordershow.do?user_id=${user.id }">
											<span><i class="icofont icofont-shopping-cart"></i></span>
			
										</a>
									</li>
									<li>
										<a href="#" >
											<span>
												<i class="icofont icofont-navigation-menu"></i>
											</span>
										</a>
										<div class="toolbar-login-cart">
											<div class="login-cart-shape">
												<div class="shape-inner-area"></div>
											</div>
											<div class="login-cart-top">
												<ul>
													<li>
														<a href="admin.jsp">
															Admin
														</a>
													</li>
													<li>
													<%
													if(request.getSession().getAttribute("user")!=null) {
													%>	
														${user.username }
													<%
													}else{
													%>
											
														<a href="login.jsp">
															Login / Signup
														</a>
													<%} %>
													</li>
													<li>
														<a href="out.do">
															Out
														</a>
													</li>
												</ul>	
											</div>
											
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2">
						<div class="navbar-brand">
							<a href="index.html">
								<img src="img/logo/logo1.png" alt="main-brand-logo">
							</a>
						</div>
					</div>
					<div class="col-md-10">
						<div class="navigation-right-area clearfix">
							<nav class="main-navigation">
								<ul>
									<li><a>${user.username }  </a></li>
									<li><a href="index.jsp">Home</a></li>
									<li><a href="contact.jsp">Register</a></li>
								</ul>
							</nav>
							<!-- Start mobile menu -->
							<div class="mobile-menu-area">
								<div class="container">
									<div class="row">
										<div class="col-md-12">
											<div class="mobile-menu">
												<nav id="dropdown">
												</nav>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- End mobile menu -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- ========================================
	==End Navigation Bar==
======================================== -->
<!-- ========================================
	==Start BreadCrumb Area==
======================================== -->
<div class="brad-crumb">
<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<div class="bread-crumb-inner-container">
				<div class="breadcrumb-title">
					<h3>Books</h3>
				</div>
				<ol class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li class="active">Books</li>        
				</ol>
			</div>
		</div>
	</div>
</div>
</div>
<!-- ========================================
	==End BreadCrumb Area==
======================================== -->

<!-- ========================================
	==Start Blog Grid==
======================================== -->
<div class="content-container section-padding-70">
<div class="container">
<div class="popupbody">
	<div class="popup-product-image">
			<img src="${book.book_img }"  alt="product-popup-image">
	</div>
	<div class="pupup-content">
		<div class="product-details-product-title">
			<h5>${book.book_name }</h5>
		</div>
		<div class="button-rating-area">
			<button class="single-product-price-btn align-middle">
				${book.book_price }
			</button>

			<div class="rating-text align-middle">
				<p>
					(Based on 3 Reviews)
				</p>
			</div>
			<div class="product-color-size-area">


			</div>
			<div class="product-cart-area popup-cart-quantity">
			<form action="addorder.do">
				<div class="product-number-cart-area align-middle">
					<div class="product-number">
					<div class="incdec">
						<input type="text" value="1" name="count" id="count"/>
						<button type="button" class="up cart-btn">+</button>
						<button type="button" class="down cart-btn"> -</button>
					</div>
				</div>
				</div>
				<div class="cart-wishlist align-middle">
					<ul>
						<li class="nv-btn-type5">
						<input type="hidden" value="${user.id}" name="uid" />
						<input type="hidden" value="${book.book_id }" name="bid" />
					
						<input type="submit" value="Add to cart">		

						</li>
					</ul>
				</div>
			</form>
			</div>
			<div class="single-product-details-text">
				<p>
					简介：${book.book_describe}; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
					作者：${book.book_author}.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
					
				</p>
			</div>
			<div class="product-share popup-item-share">
				<div class="product-sharing-title">
					<h6>Share this book</h6>
				</div>
				<ul>
					<li>
						<a href="#">
							<i class="icofont icofont-social-facebook"></i>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="icofont icofont-social-twitter"></i>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="icofont icofont-social-google-plus"></i>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="icofont icofont-social-pinterest"></i>
						</a>
					</li>
					<li>
						<a href="#">
							<i class="icofont icofont-print"></i>
						</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>
</div>
</div>
<!-- ========================================
	==End Blog Grid==
======================================== -->

<!-- ========================================
		==Start Subscribe Area==
======================================== -->
<div class="subscribe-area section-padding-bottom">
<div class="container">
	<div class="subscribe-area-inner-container">
		<div class="row">
			<div class="col-lg-offset-1 col-lg-5 col-sm-6">
				<h3>Sign Up for OUR newsletter</h3>	
			</div>
			<div class="col-lg-offset-1 col-lg-4 col-sm-6">
				<div class="subscribe-area-right">
					<div class="form-group">
						<input type="text" placeholder='Enter your email'>
						<button class="subscribe-btn">subscribe</button>
					</div>
				</div>	
			</div>
		</div>
	</div>
</div>
</div>
<!-- ========================================
		==End Subscribe Area==
======================================== -->

<!-- ========================================
		==Start footer==
======================================== -->
<footer>
<div class="container">
	<div class="row">
		<div class="col-md-2 col-sm-4">
			<div class="footer-widget">
				<div class="footer-widget-title">
					<h5>About US</h5>
				</div>
				<div class="footer-widget-content">
					<div class="about-us-widget">
						<ul>
							<li>
								<a href="#">
									About Nova.com
								</a>
							</li>
							<li>
								<a href="#">
									Terms and Condition
								</a>
							</li>
							<li>
								<a href="#">
									Privacy Policy
								</a>
							</li>
							<li>
								<a href="#">
									Corporate Sales
								</a>
							</li>
							<li>
								<a href="#">
									Careers
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3 col-sm-4">
			<div class="footer-widget">
				<div class="footer-widget-title">
					<h5>CONTACT</h5>
				</div>
				<div class="footer-widget-content">
					<div class="contact-widget">
						<ul>
							<li>
								<a href="#">
									<span><i class="icofont icofont-ui-call"></i></span>
									+88 (016) 25892353
								</a>
							</li>
							<li>
								<a href="#">
									<span><i class="icofont icofont-envelope"></i></span>
									youremail@gmail.com
								</a>
							</li>
							<li>
								<a href="#">
									<span>
										<i class="icofont icofont-social-google-map"></i>
									</span>
									121 Kazi Nazrul Islam Road
									Dhaka 1212
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-2 col-sm-4">
			<div class="footer-widget">
				<div class="footer-widget-title">
					<h5>MY ACCOUNT</h5>
				</div>
				<div class="footer-widget-content">
					<div class="my-account-widget">
						<ul>
							<li>
								<a href="#">
									My Order
								</a>
							</li>
							<li>
								<a href="#">
									My Card
								</a>
							</li>
							<li>
								<a href="#">
									Wishlist
								</a>
							</li>
							<li>
								<a href="#">
									Login
								</a>
							</li>
							<li>
								<a href="#">
									Register
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-4 col-md-offset-1 col-sm-12">
			<div class="footer-widget">
				<div class="footer-widget-title">
					<h5>Join Us</h5>
				</div>
				<div class="footer-widget-content">
					<div class="footer-social-icon">
						<div class="social-icon">
							<ul>
								<li>
									<a href="#">
										<i class="icofont icofont-social-facebook"></i>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icofont icofont-social-twitter"></i>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icofont icofont-brand-youtube"></i>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icofont icofont-social-pinterest"></i>
									</a>
								</li>
								<li>
									<a href="#">
										<i class="icofont icofont-social-google-plus"></i>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="footer-widget-title">
					<h5>PAYMENT METHODS PARTNER</h5>
				</div>
				<div class="footer-widget-content">
					<div class="payment-method-icon">
						<ul>
							<li>
								<a href="#">
									<i class="icofont icofont-mastercard"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="icofont icofont-visa"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="icofont icofont-paypal"></i>
								</a>
							</li>
							<li>
								<a href="#">
									<i class="icofont icofont-payoneer"></i>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="footer-bottom-container">
	<div class="footer-bottom-area">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-12">
					<div class="copyright">
						<p>
Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>						</p>
					</div>
					<div class="copyright-message">
						<p>
						</p>
					</div>
					</div>
				</div>
			</div>
	</div>
</div>
</footer>
<!-- =============================================
	==End footer==
============================================= -->


<!--=========================================== 
	==Start Product Details Popup=
=========================================== -->

<div id="inline-content" style="display:none;">

</div>
<!--===========================================
	==Start Product Details Popup= 
=========================================== -->


<!-- =====================================
		==Search box==
===================================== -->
<div id="menu-searchbox" class="uk-modal">
	<div class="uk-modal-dialog">
		<a class="uk-modal-close uk-close">
			
		</a>
		<div class="modal-body">
			<div class="main-menu-search-field">
				<form action="likeselect.do">
					<div class="form-group">
						<input type="text" placeholder="Search anything.." name="name">
						<button type="submit" class="menu-search-btn  waves-effect waves-light">
							<i class="icofont icofont-search-alt-1"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- =====================================
		==Search box==
===================================== -->






<!-- Vendor js
=======================================	 -->
<script src="js/vendor/jquery-1.12.1.min.js"></script>

<!-- Bootstrap js
=======================================	 -->
<script src="js/bootstrap.min.js"></script>

<!-- Camera Slider
=======================================	 -->
<script src="js/camera.min.js"></script>

<!-- venobox js
======================================	 -->
<script src="js/venobox/venobox.min.js"></script>

<!-- jQuery Ui
=======================================	 -->
<script src="js/jquery-ui.min.js"></script>

<!-- jQuery Uikit
=======================================	 -->
<script src="js/uikit.min.js"></script>

<!-- Uikit lightbox
=======================================	 -->
<script src="js/lightbox.min.js"></script>

<!-- Google Map Api
====================================	 -->
<!--<script src="https://maps.googleapis.com/maps/api/js"></script>-->

<!-- jQuery scroll
=======================================	 -->
<script src="js/jquery.nicescroll.js"></script>

<!-- Owl carousel
=======================================	 -->
<script src="js/owl.carousel.min.js"></script>

<!-- Slick carousel
=======================================	 -->
<script src="js/slick.min.js"></script>

<!-- jQuery countdown
======================================	 -->
<script src="js/jquery.countdown.min.js"></script>

<!-- Uikit Grid
=======================================	 -->
<script src="js/grid.min.js"></script>

<!-- jQuery Mean Menu
=======================================	 -->
<script src="js/jquery.meanmenu.js"></script>

<!-- Uikit slideset
=======================================	 -->
<script src="js/slideset.min.js"></script>

<!-- jQuery easing
=======================================	 -->
<script src="js/jquery.easing.min.js"></script>

<!-- Main js
=======================================	 -->
<script src="js/main.js"></script>
</body>
</html>

