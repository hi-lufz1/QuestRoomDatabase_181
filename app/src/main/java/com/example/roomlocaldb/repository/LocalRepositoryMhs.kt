package com.example.roomlocaldb.repository

import com.example.roomlocaldb.data.dao.MahasiswaDao
import com.example.roomlocaldb.data.entity.Mahasiswa
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMhs (
    private val mahasiswaDao:MahasiswaDao)
    :RepositoryMhs{
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)

    }
    
    //Metode ini memanggil fungsi getAllMahasiswa dari MahasiswaDao untuk mendapatkan semua data mahasiswa dalam bentuk aliran data (Flow).
    override fun getALlMhs(): Flow<List<Mahasiswa>> {
       return mahasiswaDao.getAllMahasiswa()
    }

    // Metode ini memanggil fungsi getMahasiswa dari Mahasiswa Dao untuk mengambil data mahasiswa berdasarkan NIM.
    override fun getMhs(nim: String): Flow<Mahasiswa> {
        return  mahasiswaDao.getMahasiswa(nim)
    }

    //Metode ini memanfaatkan fungsi deleteMahasiswa dari MahasiswaDao untuk menghapus data mahasiswa.
    override suspend fun deleteMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.deleteMahasiswa(mahasiswa)
    }

    //Metode ini menggunakan fungsi updateMahasiswa dari Mahasiswa Dao untuk memperbarui data mahasiswa di database.
    override suspend fun updateMHs(mahasiswa: Mahasiswa) {
        mahasiswaDao.updateMahasiswa(mahasiswa)
    }
}