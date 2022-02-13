package fr.isen.auriane.androiderestaurant.Detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import fr.isen.auriane.androiderestaurant.R
import fr.isen.auriane.androiderestaurant.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment() {

    private lateinit var binding: FragmentPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = arguments?.getString(URL)
        if(url?.isNotEmpty() == true) {
            Picasso.get().load(url).placeholder(R.drawable.android_logo_restaurant).into(binding.photo)
        }
    }

    companion object {
        fun newInstance(url: String) = PhotoFragment().apply { arguments = Bundle().apply { putString(
            URL, url) } }
        const val URL = "URL"
    }
}