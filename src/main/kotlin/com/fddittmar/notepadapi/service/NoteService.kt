package com.fddittmar.notepadapi.service

import com.fddittmar.notepadapi.model.Note
import com.fddittmar.notepadapi.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NoteService{
    @Autowired
    lateinit var noteRepository: NoteRepository

    fun save(note: Note){
        val aux = noteRepository.findByTitle(note.title!!)
        if(aux != null){
            note.id = aux.id
        }

        noteRepository.save(note)
    }

    fun searchAll(): List<Note>{
        return noteRepository.findAll()
    }

    fun search(title: String): Note {
        return noteRepository.findByTitle(title)
    }
}