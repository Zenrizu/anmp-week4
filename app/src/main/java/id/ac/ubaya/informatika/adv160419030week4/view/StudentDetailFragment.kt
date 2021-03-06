package id.ac.ubaya.informatika.adv160419030week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.adv160419030week4.R
import id.ac.ubaya.informatika.adv160419030week4.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*
import kotlinx.android.synthetic.main.fragment_student_list.*
import kotlinx.android.synthetic.main.student_list_item.*

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private val studentListAdapter  = StudentListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        arguments?.let {
            val idPerson = StudentDetailFragmentArgs.fromBundle(requireArguments()).idStudent
            viewModel.fetch(idPerson)
        }
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.studentLiveData.observe(viewLifecycleOwner, Observer {
            editID.setText(it.id)
            editName.setText(it.name)
            editDob.setText(it.dob)
            editPhone.setText(it.phone)
        })

    }

}