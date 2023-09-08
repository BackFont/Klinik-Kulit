package com.example.klinikkulit.dummy

import com.example.klinikkulit.R
import com.example.klinikkulit.models.Article
import com.example.klinikkulit.models.Disease


class DummyProvider {
    val articlesList = listOf(
        Article(
            "Mengenal Yayasan Kanker Indonesia, " +
                    "Wadah Kepedulian Kanker masyarakat Indonesia", R.drawable.image_12
        ),
        Article(
            "Menyimak Pengalaman John Doe, Penyintas Kanker Kulit Melanoma",
            R.drawable.image_13
        ),
        Article(
            "Memahami Semangat Hari Kanker Sedunia tiap 4 Februari",
            R.drawable.image_17
        ),
        Article(
            "Mengapa kita sangat mungkin terjangkit kanker?",
            R.drawable.image_20
        )
    )

    val diseaseList = listOf(
        Disease(
            "Actinic keratoses and intraepithelial carcinomae",
            "Kanker Non-melanoma",
            "Cukup Berbahaya",
            "Konsultasikan ke dokter",
            "Lesi yang anda miliki terdeteksi sebagai Actinic Keratoses atau Intraepithelial " +
                    "Carcinomae pada model kami. Meskipun begitu hasil prediksi ini sangat mungkin " +
                    "untuk salah. Anda sebaiknya segera berkonsultasi ke dokter.\n" +
                    "\n" +
                    "Actinic keratosis (AK) dan intraepithelial carcinoma (IEC) adalah dua kondisi " +
                    "yang berkaitan dengan pertumbuhan sel kulit yang tidak normal dan berpotensi " +
                    "menjadi kanker kulit. AK adalah kondisi prakanker kulit yang sering disebabkan " +
                    "oleh paparan berulang terhadap sinar matahari atau sinar UV. Kondisi ini juga " +
                    "dikenal dengan nama \"solar keratosis\" atau \"senile keratosis\". IEC adalah " +
                    "istilah umum yang digunakan untuk menggambarkan kanker yang terbatas pada lapisan " +
                    "sel-sel epidermis kulit, yang merupakan lapisan paling luar kulit.\n" +
                    "\n" +
                    "AK dan IEC adalah tanda peringatan yang serius untuk kesehatan kulit Anda, " +
                    "dan mereka memerlukan perawatan medis. Dalam banyak kasus, pengobatan yang " +
                    "tepat waktu dapat mencegah perkembangan menjadi kanker kulit yang lebih ganas."
        ),
        Disease(
            "Basal Cell Carcinoma",
            "Kanker Non-melanoma",
            "Cukup Berbahaya",
            "Konsultasikan ke dokter",
            "Lesi yang anda miliki terdeteksi sebagai Basal Cell Carcinoma pada model kami. " +
                    "Meskipun begitu hasil prediksi ini sangat mungkin untuk salah. Anda sebaiknya " +
                    "segera berkonsultasi ke dokter.\n" +
                    "\n" +
                    "Basal Cell Carcinoma (BCC) adalah jenis kanker kulit yang paling umum di seluruh " +
                    "dunia. Ini adalah kanker yang tumbuh dalam sel-sel basal, yang merupakan jenis " +
                    "sel kulit yang terletak di lapisan terdalam epidermis (lapisan terluar kulit). " +
                    "BCC adalah jenis kanker kulit yang relatif lambat tumbuh dan jarang menyebar ke " +
                    "bagian tubuh yang lain, tetapi dapat menjadi masalah serius jika tidak diobati."
        ),
        Disease(
            "Benign Keratosis-like Lesions",
            "Bukan Kanker",
            "Tidak Berbahaya",
            "Tidak perlu penanganan khusus",
            "Lesi yang anda miliki terdeteksi sebagai Benign Keratosis-like Lesions pada " +
                    "model kami. Meskipun begitu hasil prediksi ini sangat mungkin untuk salah. Anda " +
                    "sebaiknya segera berkonsultasi ke dokter.\n" +
                    "\n" +
                    "Benign keratosis-like lesions (lesi mirip keratosis yang jinak) adalah istilah " +
                    "yang digunakan untuk menggambarkan sekelompok kondisi kulit yang menunjukkan " +
                    "ciri-ciri fisik yang mirip dengan keratosis (kondisi kulit dengan pertumbuhan " +
                    "epidermis yang berlebihan) tetapi bersifat jinak atau non-kanker. Meskipun " +
                    "memiliki penampilan fisik yang mirip dengan keratosis, kondisi-kondisi ini " +
                    "umumnya tidak berbahaya dan tidak berkembang menjadi kanker kulit. "
        ),
        Disease(
            "Melanocytic Nevi",
            "Bukan Kanker",
            "Tidak Berbahaya",
            "Tidak perlu penanganan khusus",
            "Lesi yang anda miliki terdeteksi sebagai Melanocytic Nevi pada model kami. " +
                    "Meskipun begitu hasil prediksi ini sangat mungkin untuk salah. Anda sebaiknya " +
                    "segera berkonsultasi ke dokter.\n" +
                    "\n" +
                    "Melanocytic nevi, yang juga dikenal sebagai nevus (jamak: nevi) atau tahi lalat, " +
                    "adalah pertumbuhan pigmen kulit yang umum. Mereka adalah lesi kulit yang terdiri " +
                    "dari melanosit, sel-sel yang menghasilkan pigmen melanin yang memberikan warna " +
                    "pada kulit, rambut, dan mata. Melanocytic nevi dapat muncul pada hampir " +
                    "semua bagian tubuh dan pada orang-orang dengan berbagai warna kulit."
        ),
        Disease(
            "Melanoma",
            "Melanoma",
            "Berbahaya",
            "Segera konsultasikan ke dokter",
            "Lesi yang anda miliki terdeteksi sebagai melanoma pada model kami. " +
                    "Meskipun begitu hasil prediksi ini sangat mungkin untuk salah. Anda sebaiknya " +
                    "segera berkonsultasi ke dokter.\n" + "\n" +
                    "Kanker kulit melanoma adalah jenis kanker yang berasal dari sel-sel melanosit, " +
                    "yaitu sel-sel yang menghasilkan pigmen melanin yang memberi warna pada kulit. " +
                    "Melanoma sering kali terkait dengan paparan sinar matahari berlebihan atau radiasi UV. " +
                    "Ini adalah salah satu bentuk kanker kulit paling serius dan dapat menyebar ke " +
                    "bagian tubuh lain jika tidak diobati dengan cepat."
        ),
        Disease(
            "Dermatofibroma",
            "Bukan Kanker",
            "Tidak Berbahaya",
            "",
            "Lesi yang anda miliki terdeteksi sebagai Dermatofibroma pada model kami. " +
                    "Meskipun begitu hasil prediksi ini sangat mungkin untuk salah. Anda sebaiknya " +
                    "segera berkonsultasi ke dokter.\n" +
                    "\n" +
                    "Dermatofibroma adalah jenis lesi atau benjolan kulit yang umumnya bersifat " +
                    "jinak atau non-kanker. Ini adalah kondisi kulit yang seringkali ditemukan pada " +
                    "bagian tubuh tertentu, terutama pada pergelangan tangan, lengan bawah, dan kaki. " +
                    "Dermatofibroma biasanya muncul sebagai benjolan kecil yang terasa keras saat ditekan."
        ),
        Disease(
            "Pyogenic Granulomas and Hemorrhage",
            "Bukan Kanker",
            "Tidak Berbahaya",
            "Tidak perlu penanganan khusus",
            "Lesi yang anda miliki terdeteksi sebagai Pyogenic Granulomas atau Hemorrhage pada model kami. " +
                    "Meskipun begitu hasil prediksi ini sangat mungkin untuk salah. Anda sebaiknya segera berkonsultasi ke dokter.\n" +
                    "\n" +
                    "Pyogenic granulomas, juga dikenal sebagai granuloma pyogenik atau lobular capillary " +
                    "hemangioma, adalah pertumbuhan kulit yang umumnya berukuran kecil dan berbentuk " +
                    "benjolan yang menonjol. Meskipun namanya mengandung kata \"pyogenic\" yang " +
                    "menunjukkan infeksi, pyogenic granulomas sebenarnya bukan infeksi dan biasanya " +
                    "bukan kanker. Mereka adalah pertumbuhan pembuluh darah yang terjadi sebagai " +
                    "respons terhadap iritasi atau trauma pada kulit.\n" +
                    "\n" +
                    "Sedangkan hemorrhage adalah istilah medis yang merujuk pada perdarahan yang " +
                    "tidak normal atau kehilangan darah dari sistem peredaran darah. Perdarahan bisa " +
                    "terjadi di dalam tubuh (internal) atau di luar tubuh (eksternal) dan " +
                    "dapat disebabkan oleh berbagai kondisi atau cedera."
        )
    )
}
