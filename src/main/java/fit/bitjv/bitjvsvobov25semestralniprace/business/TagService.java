package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Tag;
import fit.bitjv.bitjvsvobov25semestralniprace.exceptions.TagNotFound;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TagRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagService {
    private final TagRepository tagRepository;
    private final ModelMapper mapper;

    public TagService(TagRepository tagRepository, ModelMapper mapper) {
        this.tagRepository = tagRepository;
        this.mapper = mapper;
    }

    public TagResponse createTag(TagRequest request) {
        Tag tag = mapper.map(request, Tag.class);
        tagRepository.save(tag);
        return mapper.map(tag, TagResponse.class);
    }

    public TagResponse updateTag(TagRequest request, Long tagId) {
        tagRepository
                .findById(tagId)
                .orElseThrow(() ->new TagNotFound(""));

        Tag tag = mapper.map(request, Tag.class);

        tag.setTagId(tagId);
        tagRepository.save(tag);
        return mapper.map(tag, TagResponse.class);
    }

    public TagResponse getTagById(Long id) {
        Tag tag = tagRepository
                .findById(id)
                .orElseThrow(()-> new TagNotFound(""));
        return mapper.map(tag, TagResponse.class);
    }

    public List<TagResponse> getAllTags() {
        List<Tag> tags = tagRepository.findAll();
        return tags.stream()
                .map((Tag tag)->mapper.map(tag, TagResponse.class))
                .collect(Collectors.toList());
    }

    public void deleteTagById(Long id) {
        tagRepository
                .findById(id)
                .orElseThrow(()-> new TagNotFound(""));
        tagRepository.deleteById(id);
    }
}
