package sszj.s.catsfacts.model

data class CatFact(
    val status: Status,
    val text: String,
    val type: String,
    val deleted: Boolean,
    val _id: String,
    val source: String,
    val updatedAt: String,
    val createdAt: String,
    val used: Boolean,
    val user: String,
    val __v: Int
)

data class Status(
    val verified: Boolean,
    val sentCount: Int,
    val feedback: String?
)
