package fit.bitjv.bitjvsvobov25semestralniprace.controllers;

import fit.bitjv.bitjvsvobov25semestralniprace.business.TagService;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTagRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tags")
public class TagController {
    private final TagService tagService;

    TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public TagResponse createTag(CreateTagRequest request){
        return tagService.createTag(request);
    }
}
