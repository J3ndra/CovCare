package com.junianto.covcare.model.contact

import com.junianto.covcare.model.contact.Contact

object ContactData {
    private val contactTitle = arrayOf(
        "Layanan Pengaduan Program Keluarga Harapan Kementerian Sosial",
        "Layanan Pengaduan Bansos Kementerian Sosial",
        "Layanan Masyarakat Kartu Prakerja",
        "Bantuan Langsung Tunai Desa",
        "Pembebasan Biaya Listrik (PLN)",
        "Tambahan insentif perumahan Kementerian PUPR",
        "Informasi lebih lanjut mengenai perpajakan",
        "Informasi lebih lanjut mengenai bea masuk dan cukai",
        "Informasi lebih lanjut mengenai Restrukturisasi Kredit atau Pembiayaan terkait dampak COVID-19 Layanan Kontak OJK",
        "Posko Pengaduan Daring bagi Masyarakat Terdampak Bencana Nasional COVID-19\nOmbudsman Pusat",
        "Kejahatan Narkotika BNN",
        "Pelayanan SEJIWA Kemen PPPA",
        "WA Center Kementerian Agama Sigap COVID-19",
        "Informasi Fungsi Relawan Desa Lawan COVID-19 Kementerian Desa, PDT, dan Transmigrasi",
        "Jalur Pengaduan bagi Pelaku Pariwisata dan Ekonomi Kreatif Terdampak COVID-19",
        "Layanan Pengiriman Surat ke Kementerian Perdagangan"
    )
    private val contactText1 = arrayOf(
            "e-mail: pengaduan@pkh.kemsos.go.id",
            "e-mail: bansoscovid19@kemsos.go.id",
            "call center: 021-25541246 (setiap hari kerja 08.00 s.d. 19.00 WIB)",
            "call center: 1500040",
            "contact center: 123",
            "e-mail: informasi@pu.go.id",
            "e-mail: informasi@pajak.go.id",
            "e-mail: info@customs.go.id",
            "e-mail: konsumen@ojk.go.id",
            "e-mail: covid19-pusat@ombudsman.go.id",
            "call center: 184",
            "e-mail: pengaduan@kemenpppa.go.id",
            "WA: 081-1159-9003",
            "call center: 1500040",
            "e-mail: info@kemenparekraf.go.id",
            "e-mail: persuratan@kemendag.go.id"

    )
    private val contactText2 = arrayOf(
            "Call center: 1500299 (setiap hari kerja 08.00 s.d. 17.00 WIB)",
            "Kontak layanan: 157",
            "",
            "SMS center: 0877-8899-0040 atau 0812-8899-0040",
            "e-mail: pln123@pln.co.id",
            "",
            "Kring Pajak: 1500200",
            "Bravo Bea Cukai: 1500225",
            "Kontak layanan: 157",
            "WA: 0811-919-3737",
            "SMS/WA: 0812-2167-5675",
            "browser: http://bit.ly/kamitetapada",
            "",
            "SMS center: 0877-8899-0040 / 0812-8899-0040",
            "website: https://pedulicovid19.kemenparekraf.go.id/",
            ""
    )
    private val contactText3 = arrayOf(
            "",
            "WA: 0811-10-222-10",
            "",
            "",
            "call center: 08122-123-123",
            "",
            "",
            "",
            "WA: 081-157-157-157",
            "",
            "",
            "call center: 119 ext. 8 / 0821-2575-1234 / 0811-1922-911",
            "",
            "",
            "WA: 0811-8956-767",
            ""
    )

    val listContact: ArrayList<Contact>
    get() {
        val list = arrayListOf<Contact>()
        for (i in contactTitle.indices) {
            val contact = Contact()
            contact.contactTitle = contactTitle[i]
            contact.contactText1 = contactText1[i]
            contact.contactText2 = contactText2[i]
            contact.contactText3 = contactText3[i]
            list.add(contact)
        }
        return list
    }
}