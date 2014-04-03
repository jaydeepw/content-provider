$(function () {
	function getCookie(c_name)
	{
		var i,x,y,ARRcookies=document.cookie.split(";");
		for (i=0;i<ARRcookies.length;i++)
		{
			x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
			y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
			x=x.replace(/^\s+|\s+$/g,"");
			if (x==c_name)
			{
				return unescape(y);
			}
		}
	}

	var utmz = getCookie('__utmz');
	if (utmz) {
		if (utmz.split('utmgclid=')[1] && utmz.split('utmgclid=')[1].split('|')[0]) {
			$('input[name="campaign"]').val("adwords");
		}
		if (utmz.split('utmctr')[1]) {
			$('input[name="term"]').val(utmz.split('utmctr=')[1].split('|')[0]);
		}
	}
	
	$('.section').click(function() {
		$('.'+$(this).attr('class').split("section ")[1]+' ul').slideToggle(100);
	});

	$('.dropdown-menu a').click(function (e) {
		e.preventDefault();
		$('.snippet').hide();
		$('#'+$(this).attr('rel')).show();
		$('#snippet-title').text($(this).text()+" ").append('<span class="caret"></span>');
	});

	$('.MonthSwitch').click(function() {
		$('.monthly').show();
		$('.PriceSwitcher .MonthSwitch').addClass('btn-primary');
		$('.yearly').hide();
		$('.PriceSwitcher .YearSwitch').removeClass('btn-primary');
		$('.pricing-list a.btn').each(function(idx, el) {
			var href = $(el).attr('href');
			$(el).attr('href', href.split('&billing_interval')[0] + '&billing_interval=month'); 
		});
		return false;
	});

	$('.YearSwitch').click(function() {
		$('.monthly').hide();
		$('.PriceSwitcher .MonthSwitch').removeClass('btn-primary');
		$('.yearly').show();
		$('.PriceSwitcher .YearSwitch').addClass('btn-primary');
		$('.pricing-list a.btn').each(function(idx, el) {
			var href = $(el).attr('href');
			$(el).attr('href', href.split('&billing_interval')[0] + '&billing_interval=year'); 
		});
		return false;
	});

	if (navigator.appVersion.indexOf("Win")!= -1) {
		$('.download-windows').show();
	}
	else if (navigator.appVersion.indexOf("Mac")!= -1) {
		$('.download-osx').show();
	} else {
		$('.download-source').show();
	}
	$('.accordion a').click(function(e) {
		e.preventDefault();
		$(this).next('div').slideToggle();
		return false;
	});
})