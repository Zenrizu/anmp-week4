package id.ac.ubaya.informatika.adv160419030week4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ubaya.informatika.adv160419030week4.model.Student

class DetailViewModel: ViewModel() {
    val studentLiveData = MutableLiveData<Student>()
    fun fetch() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        studentLiveData.value = student1
    }

}