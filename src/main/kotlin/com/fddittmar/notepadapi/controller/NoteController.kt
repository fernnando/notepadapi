package com.fddittmar.notepadapi.controller

import com.fddittmar.notepadapi.model.Note
import com.fddittmar.notepadapi.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/note")
class NoteController {

    @Autowired
    lateinit var noteService: NoteService

    @GetMapping
    fun searchAll(): List<Note>{
        return noteService!!.searchAll()
    }

    @GetMapping(value = "/title/{title}")
    fun search(@PathVariable(value = "title") title: String): Note{
        return noteService.search(title)
    }

    @PostMapping
    fun save(@RequestBody note: Note){
        noteService.save(note)
    }
}