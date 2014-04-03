$(function () {
	if (!window.Stripe) {
		$('form[data-stripe]').html('Problem communicating with our payments system, please contact <a href="mailto:support@trigger.io">support@trigger.io</a> to ask for assistance subscribing to one of our paid plans.');
		throw new Error("Failed to get Stripe.js");
	} else {
		// When stripe forms are submitted first send the data to stripe, then resubmit the form with the results of that.
		$('form[data-stripe]').submit(function (e) {
			if ($(e.target).attr('data-stripe') === undefined) {
				return;
			}
			if (!$(e.target).data('stripe-token-loaded') && !$(e.target).data('stripe-token-loading')) {
				// We don't have a stripe token, get one with the current form data
				e.preventDefault();
				$('.stripe-error', e.target).remove();
				$('[type=submit]', e.target).addClass('disabled');
				$('.spinner', e.target).show();
				$(e.target).data('stripe-token-loading', true);

				var cardDetails = {
					number: $('#card-number', e.target).val(),
					cvc: $('#card-cvc', e.target).val(),
					exp_month: $('#card-exp_month', e.target).val(),
					exp_year: $('#card-exp_year', e.target).val(),
				};

				Stripe.createToken(cardDetails, function (status, response) {
					if (response.error) {
						// Display errors
						if (response.error.param) {
							// Field error
							$('#card-'+response.error.param+'-help', e.target).prepend('<div class="alert alert-error stripe-error">'+response.error.message+'.</div>');
						} else {
							// General error
							$('.form-'+response.error.param+'-help', e.target).prepend('<div class="alert alert-error stripe-error">'+response.error.message+'.</div>');
						}

						// Re-enable form
						$('[type=submit]', e.target).removeClass('disabled');
						$(e.target).data('stripe-token-loading', false);
						$('.spinner', e.target).hide();
					} else {
						// Add the new form data and submit!
						$(e.target).append('<input type="hidden" name="stripe_token" value="'+response.id+'">')
							.append('<input type="hidden" name="card_last4" value="'+response.card.last4+'">')
							.append('<input type="hidden" name="card_type" value="'+response.card.type+'">');

						$(e.target).data('stripe-token-loaded', true);
						e.target.submit();
					}
				});

			} else if (!$(e.target).data('stripe-token-loaded') || $(e.target).data('stripe-submitted')) {
				// Prevent repeatedly submitting form
				e.preventDefault();
			} else {
				// Submit the form, but prevent repeat submissions
				$(e.target).data('stripe-submitted', true);
			}
		});
	}
});