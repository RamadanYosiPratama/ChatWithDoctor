package com.gmh.dokterlinkv2_1_1.ModelClasses

class Users {
        private var uid: String = ""
        private var username: String = ""
        private var alamat: String = ""
        private var pekerjaan: String = ""
        private var profile: String = ""
        private var cover: String = ""
        private var status: String = ""
        private var search: String = ""
        private var categoryy: String = ""
        private var sipnumer: String = ""
        private var tempat: String = ""
        private var anggota: String = ""

        constructor()

        constructor(
                uid: String,
                username: String,
                alamat: String,
                pekerjaan: String,
                profile: String,
                cover: String,
                status: String,
                search: String,
                categoryy: String,
                sipnumer: String,
                tempat: String,
                anggota: String
        ) {
            this.uid = uid
            this.username = username
            this.alamat = alamat
            this.pekerjaan = pekerjaan
            this.profile = profile
            this.cover = cover
            this.status = status
            this.search = search
            this.categoryy = categoryy
            this.sipnumer = sipnumer
            this.tempat = tempat
            this.anggota = anggota
        }

        fun getUID(): String?{
            return uid
        }

        fun setUID(uid: String){
            this.uid = uid
        }

        fun getUsername(): String?{
            return username
        }

        fun setUsername(username: String){
            this.username = username
        }

        fun getProfile(): String?{
            return profile
        }

        fun setProfile(profile: String){
            this.profile = profile
        }

        fun getCover(): String?{
            return cover
        }

        fun setCover(cover: String){
            this.cover = cover
        }

        fun getStatus(): String?{
            return status
        }

        fun setStatus(status: String){
            this.status = status
        }

        fun getSearch(): String?{
            return search
        }

        fun setSearch(search: String){
            this.search = search
        }
        fun getPekerjaan(): String?{
            return pekerjaan
        }

        fun setPekerjaan(pekerjaan: String){
            this.pekerjaan = pekerjaan
        }
        fun getAlamat(): String?{
            return alamat
        }

        fun setAlamat(alamat: String){
            this.alamat = alamat
        }
        fun getCategoryy(): String?{
            return categoryy
        }

        fun setCategoryy(categoryy: String){
            this.categoryy = categoryy
        }
        fun getSipnumer(): String?{
            return sipnumer
        }

        fun setSipnumer(sipnumer: String){
            this.sipnumer = sipnumer
        }
        fun getTempat(): String?{
            return tempat
        }

        fun setTempat(tempat: String){
            this.tempat = tempat
        }
        fun getAnggota(): String?{
            return anggota
        }

        fun setAnggota(anggota: String){
            this.anggota = anggota
        }
    }