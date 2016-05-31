<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<body>
<?php
	echo '<body';
	if(isset($this->locale)){
		echo ' lang="' . App_Controller_Plugin_Utils::getLanguageCode($this->locale) . '"';
	}
	echo '>'
?>
<?php 
	//echo $this->profileLink(); 
 echo $this->layout()->content; 
?>
<div style="display:none">
	<a href="http://www.pkstate.com" title=" 中国古代文学 " target="_BLANK"> 中国古代文学 </a>
	<a href="http://news.pkrss.com" title=" Global world news " target="_BLANK"> Global world news </a>
	<a href="http://api.pkstate.com" title=" developer online documents " target="_BLANK"> developer online documents </a>
	<a href="http://toolset.pkstate.com" title=" developer online toolset " target="_BLANK"> developer online toolset </a>
	<a href="http://shop.pkrss.com" title=" Global E-commerce " target="_BLANK"> Global E-commerce </a>
	<a href="http://image.pkrss.com" title=" Global world images " target="_BLANK"> Global world images </a>
</div>

<?php 
	echo $headScript;
	// echo '<script type="text/javascript" src="' . APPLICATION_RES_URI . '/js/default/pk.ext.js" async="async"></script>';
	
	if(class_exists('DataCache'))
		DataCache::save();
?>
</body>
</html>
</body>
</html>