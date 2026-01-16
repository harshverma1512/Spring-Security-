package com.example.practice.demo.repository

import com.example.practice.demo.model.Restaurant
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Repository
import java.util.*
import java.util.function.Function

@Repository
interface RestaurantRepository : MongoRepository<Restaurant, Int> {

    override fun <S : Restaurant?> save(entity: S): S {
        TODO("Not yet implemented")
    }

    fun getRestaurantByName(name : String) : Optional<Restaurant>

    override fun <S : Restaurant?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): Optional<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun findAll(sort: Sort): MutableList<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> insert(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> insert(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?, R : Any?> findBy(
        example: Example<S>,
        queryFunction: Function<FluentQuery.FetchableFluentQuery<S>, R>
    ): R {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Restaurant>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Int>) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Restaurant) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Int) {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Int>): MutableList<Restaurant> {
        TODO("Not yet implemented")
    }

    override fun <S : Restaurant?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }
}