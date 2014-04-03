$(document).ready(function(){
	SmallTab = $(".slide-out");
	$(SmallTab).mouseenter(function() {
		SmallTab = this;
		$(SmallTab).animate({width: "150px"}, { queue:false, duration:400 });
		}).mouseleave(function() {
		$(SmallTab).animate({width: "40px"}, { queue:false, duration:400 });
	});
});