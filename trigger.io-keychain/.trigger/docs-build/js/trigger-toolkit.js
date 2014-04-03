// javascript for "go to toolkit" page
$(function () {
	$('.spinner').show();
});
$(document).bind('toolkit', function (e, loaded) {
	$('.toolkit-checking').hide();
	if (loaded) {
		$('.toolkit-check').removeClass('alert-info alert-warning').addClass('alert-success');
		$('.toolkit-running').show();
		window.location.href = $('a.toolkit').attr('href');
	} else {
		$('.toolkit-check').removeClass('alert-info').addClass('alert-warning');
		$('.toolkit-not-running').show();
	}
});
