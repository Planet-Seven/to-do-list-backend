package fit.bitjv.bitjvsvobov25semestralniprace.controllers;

import fit.bitjv.bitjvsvobov25semestralniprace.business.TagService;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagController {
    private final TagService tagService;

    TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public TagResponse createTag(TagRequest request){
        return tagService.createTag(request);
    }

    @PutMapping("/{tagId}")
    public TagResponse updateTag(TagRequest request, @PathVariable Long tagId){
        return tagService.updateTag(request, tagId);
    }

    @GetMapping
    public List<TagResponse> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{tagId}")
    public TagResponse getTagById(@PathVariable("tagId") Long tagId){
        return tagService.getTagById(tagId);
    }

    @DeleteMapping("/{tagId}")
    public void deleteTag(@PathVariable("tagId") Long tagId){
        tagService.deleteTagById(tagId);
    }
}
