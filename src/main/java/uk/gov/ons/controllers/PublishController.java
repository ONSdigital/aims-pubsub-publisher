package uk.gov.ons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import uk.gov.ons.PubsubPublisherApplication.PubsubOutboundGateway;

@Controller
public class PublishController {

	@Value("${aims.pubsub.topic}")
	private String pubsubTopic;

	@Autowired
	private PubsubOutboundGateway messagingGateway;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("topic", String.format("Topic: %s", pubsubTopic));
		return "index";
	}

	@PostMapping("/publishMessage")
	public RedirectView publishMessage(@RequestParam("message") String message) {
		messagingGateway.sendToPubsub(message);
		return new RedirectView("/");
	}
}
