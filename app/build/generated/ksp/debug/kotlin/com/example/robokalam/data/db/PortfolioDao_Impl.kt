package com.example.robokalam.`data`.db

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class PortfolioDao_Impl(
  __db: RoomDatabase,
) : PortfolioDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfPortfolio: EntityInsertAdapter<Portfolio>
  init {
    this.__db = __db
    this.__insertAdapterOfPortfolio = object : EntityInsertAdapter<Portfolio>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `portfolio` (`email`,`username`,`password`,`name`,`college`,`skills`,`projectTitle`,`projectDescription`) VALUES (?,?,?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: Portfolio) {
        statement.bindText(1, entity.email)
        statement.bindText(2, entity.username)
        statement.bindText(3, entity.password)
        statement.bindText(4, entity.name)
        statement.bindText(5, entity.college)
        statement.bindText(6, entity.skills)
        statement.bindText(7, entity.projectTitle)
        statement.bindText(8, entity.projectDescription)
      }
    }
  }

  public override suspend fun insert(portfolio: Portfolio): Unit = performSuspending(__db, false,
      true) { _connection ->
    __insertAdapterOfPortfolio.insert(_connection, portfolio)
  }

  public override suspend fun getPortfolio(email: String): Portfolio? {
    val _sql: String = "SELECT * FROM portfolio WHERE email = ?"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, email)
        val _columnIndexOfEmail: Int = getColumnIndexOrThrow(_stmt, "email")
        val _columnIndexOfUsername: Int = getColumnIndexOrThrow(_stmt, "username")
        val _columnIndexOfPassword: Int = getColumnIndexOrThrow(_stmt, "password")
        val _columnIndexOfName: Int = getColumnIndexOrThrow(_stmt, "name")
        val _columnIndexOfCollege: Int = getColumnIndexOrThrow(_stmt, "college")
        val _columnIndexOfSkills: Int = getColumnIndexOrThrow(_stmt, "skills")
        val _columnIndexOfProjectTitle: Int = getColumnIndexOrThrow(_stmt, "projectTitle")
        val _columnIndexOfProjectDescription: Int = getColumnIndexOrThrow(_stmt,
            "projectDescription")
        val _result: Portfolio?
        if (_stmt.step()) {
          val _tmpEmail: String
          _tmpEmail = _stmt.getText(_columnIndexOfEmail)
          val _tmpUsername: String
          _tmpUsername = _stmt.getText(_columnIndexOfUsername)
          val _tmpPassword: String
          _tmpPassword = _stmt.getText(_columnIndexOfPassword)
          val _tmpName: String
          _tmpName = _stmt.getText(_columnIndexOfName)
          val _tmpCollege: String
          _tmpCollege = _stmt.getText(_columnIndexOfCollege)
          val _tmpSkills: String
          _tmpSkills = _stmt.getText(_columnIndexOfSkills)
          val _tmpProjectTitle: String
          _tmpProjectTitle = _stmt.getText(_columnIndexOfProjectTitle)
          val _tmpProjectDescription: String
          _tmpProjectDescription = _stmt.getText(_columnIndexOfProjectDescription)
          _result =
              Portfolio(_tmpEmail,_tmpUsername,_tmpPassword,_tmpName,_tmpCollege,_tmpSkills,_tmpProjectTitle,_tmpProjectDescription)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
