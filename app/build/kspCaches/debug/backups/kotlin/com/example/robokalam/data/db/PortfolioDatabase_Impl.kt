package com.example.robokalam.`data`.db

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class PortfolioDatabase_Impl : PortfolioDatabase() {
  private val _portfolioDao: Lazy<PortfolioDao> = lazy {
    PortfolioDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(2,
        "b987819a9dab9c55673b601ee1781870", "716fc0d32f6cf4b0165ccbdc23f041f1") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `portfolio` (`email` TEXT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL, `name` TEXT NOT NULL, `college` TEXT NOT NULL, `skills` TEXT NOT NULL, `projectTitle` TEXT NOT NULL, `projectDescription` TEXT NOT NULL, PRIMARY KEY(`email`))")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b987819a9dab9c55673b601ee1781870')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `portfolio`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection):
          RoomOpenDelegate.ValidationResult {
        val _columnsPortfolio: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsPortfolio.put("email", TableInfo.Column("email", "TEXT", true, 1, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("username", TableInfo.Column("username", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("password", TableInfo.Column("password", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("name", TableInfo.Column("name", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("college", TableInfo.Column("college", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("skills", TableInfo.Column("skills", "TEXT", true, 0, null,
            TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("projectTitle", TableInfo.Column("projectTitle", "TEXT", true, 0,
            null, TableInfo.CREATED_FROM_ENTITY))
        _columnsPortfolio.put("projectDescription", TableInfo.Column("projectDescription", "TEXT",
            true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysPortfolio: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesPortfolio: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoPortfolio: TableInfo = TableInfo("portfolio", _columnsPortfolio,
            _foreignKeysPortfolio, _indicesPortfolio)
        val _existingPortfolio: TableInfo = read(connection, "portfolio")
        if (!_infoPortfolio.equals(_existingPortfolio)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |portfolio(com.example.robokalam.data.db.Portfolio).
              | Expected:
              |""".trimMargin() + _infoPortfolio + """
              |
              | Found:
              |""".trimMargin() + _existingPortfolio)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "portfolio")
  }

  public override fun clearAllTables() {
    super.performClear(false, "portfolio")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(PortfolioDao::class, PortfolioDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override
      fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>):
      List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun dao(): PortfolioDao = _portfolioDao.value
}
