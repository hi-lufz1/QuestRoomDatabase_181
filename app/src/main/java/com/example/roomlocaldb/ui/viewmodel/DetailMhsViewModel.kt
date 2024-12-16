package com.example.roomlocaldb.ui.viewmodel

import com.example.roomlocaldb.data.entity.Mahasiswa

data class DetailUiState(
    val detailUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
){
    val isUiEventEmpty: Boolean
        get () = detailUiEvent == MahasiswaEvent()
    val isUiEventNotEmpty: Boolean
        get () = detailUiEvent != MahasiswaEvent()
}

// Data Class untuk menampung data yang akan ditampilkan di UI

// memindahkan data dri entitiy ke ui
fun Mahasiswa.toDetailUiEvent() : MahasiswaEvent{
    return  MahasiswaEvent(
        nim = nim,
        nama = nama,
        jenisKelamin = jenisKelamin,
        alamat = alamat,
        kelas = kelas,
        angkatan = angkatan
    )
}