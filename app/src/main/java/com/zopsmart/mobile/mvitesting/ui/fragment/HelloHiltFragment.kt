package com.zopsmart.mobile.mvitesting.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.airbnb.epoxy.carousel
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.zopsmart.mobile.mvitesting.R
import com.zopsmart.mobile.mvitesting.TaskCarouselBindingModel_
import com.zopsmart.mobile.mvitesting.databinding.HelloHiltFragmentBinding
import com.zopsmart.mobile.mvitesting.model.CarouselItem
import com.zopsmart.mobile.mvitesting.model.HelloHiltState
import com.zopsmart.mobile.mvitesting.model.Task
import com.zopsmart.mobile.mvitesting.task
import com.zopsmart.mobile.mvitesting.title
import com.zopsmart.mobile.mvitesting.ui.HelloHiltViewModel
import com.zopsmart.mobile.mvitesting.utils.viewBinding

class HelloHiltFragment : Fragment(R.layout.hello_hilt_fragment), MavericksView {
    private val binding: HelloHiltFragmentBinding by viewBinding()

    private val viewModel: HelloHiltViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setListData(tasks, carouselItems)
    }

    private fun setupRecyclerView(helloHiltState: HelloHiltState) {
        binding.rvTask.withModels {
            // First title
            title {
                id("title-id")
                title(helloHiltState.title)
            }

            // Carousel Item
            val carouselItemModels = helloHiltState.carouselItem.map { currentItem ->
                TaskCarouselBindingModel_()
                    .id(currentItem.id)
                    .carouselItem(currentItem)
                    .clickListener { v ->
                    }
            }

            // Carousel
            // This extension function come with epoxy
            carouselItemModels.let {
                carousel {
                    id("car")
                    models(it)
                }
            }
            // Task title
            // item_title.xml
            title {
                id("title-id")
                title("Need Assistant")
            }

            // Tasks
            tasks.forEach { currentTask ->
                // item_task.xml
                task {
                    id(currentTask.id)
                    task(currentTask)
                    clickListener { v ->
                    }
                }
            }
        }
    }

    private val tasks = listOf(
        Task(
            "id1",
            "Audio & Video",
            4,
            "https://images.pexels.com/photos/4298629/pexels-photo-4298629.jpeg"
        ),
        Task(
            "id2",
            "Updating",
            6,
            "https://images.pexels.com/photos/3533228/pexels-photo-3533228.png"
        ),
        Task(
            "id3",
            "Drink and food",
            2,
            "https://images.pexels.com/photos/4750165/pexels-photo-4750165.jpeg"
        ),
        Task(
            "id4",
            "Security",
            4,
            "https://images.pexels.com/photos/4298629/pexels-photo-4298629.jpeg"
        ),
        Task(
            "id5",
            "Dark theme",
            6,
            "https://images.pexels.com/photos/4298629/pexels-photo-4298629.jpeg"
        )
    )

    private val carouselItems = listOf(
        CarouselItem(
            "id11",
            "Event problems",
            "Call issue center",
            "https://images.pexels.com/photos/4298629/pexels-photo-4298629.jpeg"
        ),
        CarouselItem(
            "id21",
            "Emergency",
            "Call policy",
            "https://images.pexels.com/photos/4298629/pexels-photo-4298629.jpeg"
        ),
        CarouselItem(
            "id31",
            "Tassk 4",
            "Call google",
            "https://images.pexels.com/photos/4298629/pexels-photo-4298629.jpeg"
        )
    )

    override fun invalidate() = withState(viewModel) {
        setupRecyclerView(it)
    }
}
