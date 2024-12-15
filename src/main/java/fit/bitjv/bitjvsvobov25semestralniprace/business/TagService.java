package fit.bitjv.bitjvsvobov25semestralniprace.business;

import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTagRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.CreateTaskRequest;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TagResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.dto.TaskResponse;
import fit.bitjv.bitjvsvobov25semestralniprace.entity.Tag;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TagRepository;
import fit.bitjv.bitjvsvobov25semestralniprace.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TagService {
    private final TagRepository tagRepository;
    private final ModelMapper mapper;

    public TagService(TagRepository tagRepository, ModelMapper mapper) {
        this.tagRepository = tagRepository;
        this.mapper = mapper;
    }

    public TagResponse createTag(CreateTagRequest request) {
        Tag tag = mapper.map(request, Tag.class);
        tagRepository.save(tag);
        return mapper.map(tag, TagResponse.class);
    }
}
